/*
 * This file is generated by jOOQ.
*/
package com.imos.sample.model.tables.records;


import com.imos.sample.model.tables.Address;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressRecord extends UpdatableRecordImpl<AddressRecord> implements Record7<Integer, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1346031309;

    /**
     * Setter for <code>library.address.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>library.address.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>library.address.first_street</code>.
     */
    public void setFirstStreet(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>library.address.first_street</code>.
     */
    public String getFirstStreet() {
        return (String) get(1);
    }

    /**
     * Setter for <code>library.address.second_street</code>.
     */
    public void setSecondStreet(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>library.address.second_street</code>.
     */
    public String getSecondStreet() {
        return (String) get(2);
    }

    /**
     * Setter for <code>library.address.pin</code>.
     */
    public void setPin(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>library.address.pin</code>.
     */
    public String getPin() {
        return (String) get(3);
    }

    /**
     * Setter for <code>library.address.city</code>.
     */
    public void setCity(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>library.address.city</code>.
     */
    public String getCity() {
        return (String) get(4);
    }

    /**
     * Setter for <code>library.address.land_mark</code>.
     */
    public void setLandMark(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>library.address.land_mark</code>.
     */
    public String getLandMark() {
        return (String) get(5);
    }

    /**
     * Setter for <code>library.address.premises</code>.
     */
    public void setPremises(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>library.address.premises</code>.
     */
    public String getPremises() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Address.ADDRESS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Address.ADDRESS.FIRST_STREET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Address.ADDRESS.SECOND_STREET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Address.ADDRESS.PIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Address.ADDRESS.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Address.ADDRESS.LAND_MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Address.ADDRESS.PREMISES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getFirstStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSecondStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLandMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPremises();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFirstStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSecondStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLandMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPremises();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value2(String value) {
        setFirstStreet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value3(String value) {
        setSecondStreet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value4(String value) {
        setPin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value5(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value6(String value) {
        setLandMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value7(String value) {
        setPremises(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressRecord
     */
    public AddressRecord() {
        super(Address.ADDRESS);
    }

    /**
     * Create a detached, initialised AddressRecord
     */
    public AddressRecord(Integer id, String firstStreet, String secondStreet, String pin, String city, String landMark, String premises) {
        super(Address.ADDRESS);

        set(0, id);
        set(1, firstStreet);
        set(2, secondStreet);
        set(3, pin);
        set(4, city);
        set(5, landMark);
        set(6, premises);
    }
}
