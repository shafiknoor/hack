
package com.infy.hackathon.benefits;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_id",
    "state",
    "network",
    "metallicType",
    "effectiveStartDate",
    "effectiveEndDate",
    "productType",
    "inNetwork",
    "outOfNetwork"
})
@Document(collection="planBenefits")
public class PlanBenefits {

    @JsonProperty("_id")
    @Id
    private String _id;
    @JsonProperty("state")
    private String state;
    @JsonProperty("network")
    private String network;
    @JsonProperty("metallicType")
    private String metallicType;
    @JsonProperty("effectiveStartDate")
    private String effectiveStartDate;
    @JsonProperty("effectiveEndDate")
    private String effectiveEndDate;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("netWorkType")
    private NetworkType netWorkType;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlanBenefits() {
    }

    /**
     * 
     * @param metallicType
     * @param _id
     * @param inNetwork
     * @param effectiveStartDate
     * @param state
     * @param outOfNetwork
     * @param network
     * @param productType
     * @param effectiveEndDate
     * @param netWorkType 
     */
    public PlanBenefits(String _id, String state, String network, String metallicType, String effectiveStartDate, String effectiveEndDate, String productType, InNetwork inNetwork, OutOfNetwork outOfNetwork, NetworkType netWorkType) {
        super();
        this._id = _id;
        this.state = state;
        this.network = network;
        this.metallicType = metallicType;
        this.effectiveStartDate = effectiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
        this.productType = productType;
        this.netWorkType = netWorkType; 
    }

    @JsonProperty("_id")
    public String get_id() {
        return _id;
    }

    @JsonProperty("_id")
    public void set_id(String _id) {
        this._id = _id;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    @JsonProperty("metallicType")
    public String getMetallicType() {
        return metallicType;
    }

    @JsonProperty("metallicType")
    public void setMetallicType(String metallicType) {
        this.metallicType = metallicType;
    }

    @JsonProperty("effectiveStartDate")
    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    @JsonProperty("effectiveStartDate")
    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    @JsonProperty("effectiveEndDate")
    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    @JsonProperty("effectiveEndDate")
    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }
    @JsonProperty("netWorkType")
    public NetworkType getNetWorkType() {
		return netWorkType;
	}
    @JsonProperty("netWorkType")
	public void setNetWorkType(NetworkType netWorkType) {
		this.netWorkType = netWorkType;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_id", _id).append("state", state).append("network", network).append("metallicType", metallicType).append("effectiveStartDate", effectiveStartDate).append("effectiveEndDate", effectiveEndDate).append("productType", productType).append("netWorkType", netWorkType).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metallicType).append(_id).append(additionalProperties).append(netWorkType).append(effectiveStartDate).append(state).append(network).append(productType).append(effectiveEndDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlanBenefits) == false) {
            return false;
        }
        PlanBenefits rhs = ((PlanBenefits) other);
        return new EqualsBuilder().append(metallicType, rhs.metallicType).append(netWorkType, rhs.netWorkType).append(_id, rhs._id).append(additionalProperties, rhs.additionalProperties).append(effectiveStartDate, rhs.effectiveStartDate).append(state, rhs.state).append(network, rhs.network).append(productType, rhs.productType).append(effectiveEndDate, rhs.effectiveEndDate).isEquals();
    }

}
