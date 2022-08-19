package vttp.miniproject01.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class CarparkDetails {
    
    private String weekdayMin;
    private String weekdayRate;
    private String carparkNo;      // ppCode
    private String name;      // ppName
    private String parkingSystem;       // C - Coupon Parking System, B - Electronic Parking System
    private String vechicle;        // vehCat
    private String satdayMin;
    private String satdayRate;
    private String sunPHMin;
    private String sunPHRate;
    private String coordinates;
    private String startTime;
    private String endTime;
    private String parkCapacity;

    public String getWeekdayMin() {     return weekdayMin;  }
    public void setWeekdayMin(String weekdayMin) {      this.weekdayMin = weekdayMin;   }

    public String getWeekdayRate() {    return weekdayRate;     }
    public void setWeekdayRate(String weekdayRate) {    this.weekdayRate = weekdayRate;     }

    public String getCarparkNo() {      return carparkNo;   }
    public void setCarparkNo(String carparkNo) {    this.carparkNo = carparkNo; }

    public String getName() {   return name;    }
    public void setName(String name) {  this.name = name;   }

    public String getParkingSystem() {  return parkingSystem;   }
    public void setParkingSystem(String parkingSystem) {    this.parkingSystem = parkingSystem;     }

    public String getVechicle() {   return vechicle;    }
    public void setVechicle(String vechicle) {      this.vechicle = vechicle;   }

    public String getSatdayMin() {      return satdayMin;   }
    public void setSatdayMin(String satdayMin) {    this.satdayMin = satdayMin;     }

    public String getSatdayRate() {     return satdayRate;      }
    public void setSatdayRate(String satdayRate) {      this.satdayRate = satdayRate;       }
    
    public String getSunPHMin() {
        return sunPHMin;
    }
    public void setSunPHMin(String sunPHMin) {
        this.sunPHMin = sunPHMin;
    }
    public String getSunPHRate() {
        return sunPHRate;
    }
    public void setSunPHRate(String sunPHRate) {
        this.sunPHRate = sunPHRate;
    }
    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    // Create Model from JsonObject
    public static CarparkDetails create(JsonObject jo, JsonObject coordinates) {
        CarparkDetails n = new CarparkDetails();
        n.setCarparkNo(jo.getString("ppCode"));
        n.setWeekdayMin(jo.getString("weekdayMin"));
        n.setWeekdayRate(jo.getString("weekdayRate"));
        n.setName(jo.getString("ppName"));
        n.setParkingSystem(jo.getString("parkingSystem"));
        n.setVechicle(jo.getString("vehCat"));
        n.setSatdayMin(jo.getString("satdayMin"));
        n.setSatdayRate(jo.getString("satdayRate"));
        n.setSunPHMin(jo.getString("sunPHMin"));
        n.setSunPHRate(jo.getString("sunPHRate"));
        n.setCoordinates(coordinates.getString("coordinates"));
        n.setStartTime(jo.getString("startTime"));
        n.setEndTime(jo.getString("endTime"));
        return n;
    }

    // Convert model to JsonObject
    public JsonObject toJson(CarparkAvail a) {
        return Json.createObjectBuilder()
            .add("ppCode", carparkNo)
            .add("weekdayMin", weekdayMin)
            .add("weekdayRate", weekdayRate)
            .add("ppName", name)
            .add("parkingSystem", parkingSystem)
            .add("vehCat", vechicle)
            .add("satdayMin", satdayMin)
            .add("satdayRate", satdayRate)
            .add("sunPHMin", sunPHMin)
            .add("sunPHRate", sunPHRate)
            .add("coordinates", coordinates)
            .add("startTime", startTime)
            .add("endTime", endTime)
            .add("parkCapacity", parkCapacity)
            .build();
    }


}
