/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.model;

import com.chargebee.models.Addon;
import com.chargebee.models.Addon.ChargeType;
import com.chargebee.models.Addon.CreateRequest;
import com.chargebee.models.Addon.PeriodUnit;
import com.chargebee.models.Addon.Type;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author alok
 */
@Data
@Builder
public class BIMAddon {

    private String id;
    private String name;
    private String invoiceName;
    private Integer price;
    private Integer period;
    private PeriodUnit periodUnit;
    private ChargeType chargeType;
    private Type type;

    public static class BIMAddonBuilder {

        public BIMAddonBuilder() {

        }
    }

    public static class BIMAddonMapper {

        private Addon addon;
        private CreateRequest createRequest;

        public BIMAddonMapper() {
            try {
                createRequest = Addon.create();
            } catch (IOException ex) {
                Logger.getLogger(BIMAddon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public BIMAddonMapper id(String id) {
            createRequest.id(id);
            return this;
        }
        
        public BIMAddon build() {
            return null;
        }
    }
}
