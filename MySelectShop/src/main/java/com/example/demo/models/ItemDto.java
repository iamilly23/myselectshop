package com.example.demo.models;

import org.json.JSONObject;

import lombok.Getter;

@Getter
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}
