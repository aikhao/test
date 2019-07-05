package ru.yandex.disk.api.disk;

import io.restassured.http.ContentType;
import ru.yandex.disk.Config;
import ru.yandex.disk.api.EndPoints;
import ru.yandex.disk.api.models.MetainformationAboutDiskUser;

import static io.restassured.RestAssured.given;
import static ru.yandex.disk.Config.API_HOST;

public class DiskApi {

    private static final String basePath = EndPoints.disk;

    public DiskApi(){

    }

    public MetainformationAboutDiskUser GetAllMetainformationAboutDiskUser(){
        MetainformationAboutDiskUser metainformationAboutDiskUser = given().
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    header("Authorization", Config.TOKEN).
                when().
                    get(API_HOST + basePath).
                then().
//                    statusCode(200).
                    extract().
                    body().
                    as(MetainformationAboutDiskUser.class);
        return metainformationAboutDiskUser;
    }
}

