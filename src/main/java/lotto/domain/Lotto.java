package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int DEFAULT_LOTTO_COUNT = 6;
    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String DEFAULT_CHARACTER = "";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String lottoNumber) {
        this.lottoNumbers = Stream.of(winLottoNumbers(lottoNumber))
                                        .map(number -> LottoNumber.from(number))
                                        .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(CreationLottoNumber creationLottoNumber) {
        return new Lotto(creationLottoNumber.automatic());
    }

    private String[] winLottoNumbers(String winLottoNumbers) {
        String[] splitWinLottoNumbers = winLottoNumbers.replaceAll(DEFAULT_WHITE_SPACE_CHARACTER, DEFAULT_CHARACTER)
                                                            .split(DEFAULT_SPLIT_CHARACTER);
        validationSplitLottoNumbers(splitWinLottoNumbers);
        return splitWinLottoNumbers;
    }

    private void validationSplitLottoNumbers(String[] splitWinLottoNumbers) {
        if(splitWinLottoNumbers.length != DEFAULT_LOTTO_COUNT){
            throw new IllegalArgumentException("로또 번호 개수가 정확하지 않습니다.");
        }
    }

    public boolean contain(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int matchCountLottoNumbers(PrizeLotto prizeLotto) {
        return (int) lottoNumbers.stream()
                                .filter(lottoNumber -> containLottoNumber(prizeLotto, lottoNumber))
                                .count();
    }

    private boolean containLottoNumber(PrizeLotto prizeLotto, LottoNumber lottoNumber) {
        return prizeLotto.matchNumber(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }


}
