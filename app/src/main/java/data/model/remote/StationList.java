package data.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import data.model.BiciMad;

import java.util.ArrayList;

public class StationList {
    @SerializedName("stations")
    @Expose
    private ArrayList<BiciMad> estaciones = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<BiciMad> getContacts() {
        return estaciones;
    }

    /**
     * @param estaciones The contacts
     */
    public void setContacts(ArrayList<BiciMad> estaciones) {
        this.estaciones = estaciones;
    }
}
