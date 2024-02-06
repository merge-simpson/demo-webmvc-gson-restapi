package example.demo.domain.types;

import com.google.gson.annotations.SerializedName;

public enum Gender {
    @SerializedName(value = "m", alternate = {"male", "남", "남성"})
    M,
    @SerializedName(value = "f", alternate = {"female", "여", "여성"})
    F
}
