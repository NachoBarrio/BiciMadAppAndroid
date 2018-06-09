package data.model.remote;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/get_stations/{username}/{password}")
    @FormUrlEncoded
    Call<StationList> getStations();
}
