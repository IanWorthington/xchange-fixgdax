package org.knowm.xchange.gatehub;

import static java.math.BigDecimal.ZERO;

import java.util.ArrayList;
import java.util.Collection;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.gatehub.dto.Balance;

public class GatehubAdapters {
  public static Collection<Wallet> adaptWallets(Collection<Balance> balances) {
    Collection<Wallet> wallets = new ArrayList<>();
    for (Balance b : balances) {
      wallets.add(new Wallet(new org.knowm.xchange.dto.account.Balance(new Currency(b.getVault().getAssetCode()), b.getTotal(), b.getAvailable(), ZERO, ZERO, ZERO, ZERO, b.getPending())));
    }
    return wallets;
  }
}
