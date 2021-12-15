package lotto.domain;

public class LottoShop {
    private static final String EXCEPTION_MESSAGE_MORE_MANUAL_GAME = "구매한 게임수보다 수동 게임수가 많습니다.";
    private static final String EXCEPTION_MESSAGE_MIN_PURCHASE_AMOUNT = "1000원 이상 입력되어야 합니다.";
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MIN_BUY_ROUND = 1;

    private final int purchaseAmount;
    private final int buyRound;
    private final int manualRound;

    public LottoShop(int purchaseAmount, int manualRound) {
        this.purchaseAmount = purchaseAmount;
        this.buyRound = getBuyRound();
        this.manualRound = manualRound;
        validateManualRound(manualRound);
    }

    private void validateManualRound(int manualRound) {
        if (buyRound < manualRound) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MORE_MANUAL_GAME);
        }
    }

    public int getBuyRound() {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount / MIN_PURCHASE_AMOUNT < MIN_BUY_ROUND) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_PURCHASE_AMOUNT);
        }
    }

    public int getBuyAmount() {
        return buyRound * MIN_PURCHASE_AMOUNT;
    }

    public int getManualRound() {
        return manualRound;
    }

    public int getAutoRound() {
        return buyRound - manualRound;
    }
}
