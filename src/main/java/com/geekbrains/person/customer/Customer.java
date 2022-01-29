package com.geekbrains.person.customer;

import com.geekbrains.market.Market;
import com.geekbrains.person.Person;
import com.geekbrains.person.seller.Seller;
import com.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Customer extends Person {
    private List<Product> expectedPurchaseList;
    private List<Product> purchaseList;
    private String sellerName;
    private String sellerLastname;
   // private List<Seller> sellerNameLastname;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerLastname() {
        return sellerLastname;
    }

    public void setSellerLastname(String sellerLastname) {
        this.sellerLastname = sellerLastname;
    }



    public Customer(List<Product> expectedPurchaseList, int cash, String sellerName, String sellerLastname ) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.sellerName = sellerName;
        this.sellerLastname =sellerLastname;
       // this.sellerNameLastname = sellerNameLastname;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        if (purchaseList == null) {
            purchaseList = new ArrayList<>();
        }

        purchaseList.add(product);
    }
    public void findProductOnMarket(Market market) {

        boolean isBoughtSeller = true;


        for (Seller seller1 : market.getSellers()) {

//          проверяет имя заданого продавца
            isBoughtSeller = seller1.sellNameLastName(this, market);
            if (!isBoughtSeller) {
                continue;
                
                // если продавец не тот который задан идем к следующему
            }


            int count = 0;

            while (count < 1) {
                //идем по продавцам
                for (Seller seller : market.getSellers()) {

//          проверяет имя заданого продавца
                    isBoughtSeller = seller.sellNameLastName(this, market);
                    // если продавец не тот который задан идем к следующему

                    if (!isBoughtSeller) {
                        continue;
                    } else {
                        // если продавец наш то идем по списку покупок

                        for (Product product : getExpectedPurchaseList()) {
                            // метод проверяет наличие нужного товара и хватит ли нам денег на него
                            boolean isBought = seller.sellProducts(this, product);
                            // если нет то выходим из детущего цикла и из wile передаем один и
                            // переходим к циклам после него
                            if (!isBought) {
                                count = 1;
                                break;

                            }
                            // если все ок то совершаем покупку

                            seller.Sale(this, product);


                        }


                    }


                }
                // если по циклам нет заданного прововца   то выходим из них к следующему после wile
                count = 1;

            }
            // проходимся по продовцам

            for (Seller seller : market.getSellers()) {

                // если уже ьыли покупки то уходим
                if (purchaseList.size() > 0) {
                    break;
                }


                isBoughtSeller = seller.sellNameLastName(this, market);
                // если имя совпадает с заданным продавцом то ищем дгугого т.к у него нет нужного товара
                // выяснили из вложенного цикла выше
                if (isBoughtSeller) {
                    continue;
                } else {

                    for (Product product : getExpectedPurchaseList()) {

                        // проходимся по списку покупок

                        boolean isBought = seller.sellProducts(this, product);
                        // если продукта нет или цена дорогая выходим
                        if (!isBought) {

                            break;
                        }
                        // еслим все ок покупаем
                        seller.Sale(this, product);
                    }

                }
            }
        }
    }


    public void info() {

        StringBuilder result = new StringBuilder("Я купил ");
        if (purchaseList.size() == 0) {
            result.append("ничего");
        } else {

            for (Product product : purchaseList) {
                result.append(product.getName());
                result.append(" в количестве ");
                result.append(product.getQuantity());
                result.append(" ");
            }

        }


            result.append(". У меня осталось: ");
            result.append(getCash());
            result.append(" рублей");

            System.out.println(result);
        }


        public List<Product> getExpectedPurchaseList () {
            return expectedPurchaseList;
        }




    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

    
    

   }
