
package guru.springframework.api.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Getter
@Setter
public class Address implements Serializable
{

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    @Setter(lombok.AccessLevel.NONE)
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3734311591897393438L;
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
