package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_RANGE = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int gameRound, CreationLottoNumber creationLottoNumber) {
        List<Lotto> lottoGroup = IntStream.range(START_RANGE, gameRound)
                .mapToObj(m -> Lotto.from(creationLottoNumber))
                .collect(Collectors.toList());
        return new Lottos(lottoGroup);
    }

    public LottoResults getResults(PrizeLotto prizeLotto) {
        return LottoResults.of(lottos, prizeLotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
