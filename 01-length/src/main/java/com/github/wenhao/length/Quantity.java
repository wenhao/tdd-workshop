/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.wenhao.length;

import static com.github.wenhao.length.QuantityUnit.INCH;

public class Quantity {
    private int amount;
    private QuantityUnit unit;

    public Quantity(final int amount, final QuantityUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmount() {
        return amount;
    }

    private QuantityUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(final Object obj) {
        Quantity quantity = (Quantity) obj;
        int myBasicAmount = amount * unit.getRate();
        int otherBasicAmount = quantity.getAmount() * quantity.getUnit().getRate();
        return myBasicAmount == otherBasicAmount;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + unit.hashCode();
        return result;
    }

    public Quantity plus(final Quantity quantity) {
        int plusAmount = amount * unit.getRate() + quantity.getAmount() * quantity.getUnit().getRate();
        return new Quantity(plusAmount, INCH);
    }
}
