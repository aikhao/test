package com.xcart.demostore.page;

import com.codeborne.selenide.Selenide;

public class CustomerPage extends Page {

    public CustomerPage open(){
        Selenide.open("cart.php");
        return this;
    }
}
