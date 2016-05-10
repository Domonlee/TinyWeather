package cn.domon.tinyweather.Data;

import java.util.List;

/**
 * Created by Domon on 16-5-10.
 */
public class CityInfoListData {
    private List<CityInfoData> city_info;
    private String status;

    public List<CityInfoData> getCity_info() {
        return city_info;
    }

    public void setCity_info(List<CityInfoData> city_info) {
        this.city_info = city_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CityInfoListData{" +
                "cityInfoDatas=" + city_info.toString() +
                ", status='" + status + '\'' +
                '}';
    }
}
