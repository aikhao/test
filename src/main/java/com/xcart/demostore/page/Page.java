package com.xcart.demostore.page;

import com.codeborne.selenide.Selenide;
import org.junit.*;

import static com.codeborne.selenide.Configuration.baseUrl;

public class Page {

    public Page open(){
        Selenide.open("");
        return this;
    }
}
