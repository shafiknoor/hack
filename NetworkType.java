package com.infy.hackathon.benefits;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"inNetwork",
    "outOfNetwork",
})

public class NetworkType {
	@JsonProperty("inNetwork")
    private InNetwork inNetwork;
    @JsonProperty("outOfNetwork")
    private OutOfNetwork outOfNetwork;
    
    public NetworkType(InNetwork inNetwork, OutOfNetwork outOfNetwork) {
        super();
        this.inNetwork = inNetwork;
        this.outOfNetwork = outOfNetwork;
    }
    
    @JsonProperty("inNetwork")
    public InNetwork getInNetwork() {
        return inNetwork;
    }

    @JsonProperty("inNetwork")
    public void setInNetwork(InNetwork inNetwork) {
        this.inNetwork = inNetwork;
    }

    @JsonProperty("outOfNetwork")
    public OutOfNetwork getOutOfNetwork() {
        return outOfNetwork;
    }

    @JsonProperty("outOfNetwork")
    public void setOutOfNetwork(OutOfNetwork outOfNetwork) {
        this.outOfNetwork = outOfNetwork;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("inNetwork", inNetwork).append("outOfNetwork", outOfNetwork).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(outOfNetwork).append(inNetwork).toHashCode();
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkType) == false) {
            return false;
        }
        NetworkType rhs = ((NetworkType) other);
        return new EqualsBuilder().append(inNetwork, rhs.inNetwork).append(outOfNetwork, rhs.outOfNetwork).isEquals();
    }
}
