package mx.uady.sicei.model;
/**
 * Una clase para definir un empleado y sus características.
 * Utiliza intefaz Table que se utilizará para insertar todos los registros
 * de empleado en una tabla.
 * @author Samantha Caamal, Montserrat Bustamante 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // f(x) = y
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Employee() {
    }

    /** 
     * Constructor de la clase empleado.
     */
    public Employee(String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    /** 
     * Método get para el Id del empleado.
     * @return Integer el Id del empleado.
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Método set para el Id del empleado.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Método get para el Nombre del empleado.
     * @return String el Nombre del empleado.
     */
    public String getName() {
        return name;
    }

    /** 
     * Método set para el Nombre del empleado.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Método get para el Correo electrónico del empleado.
     * @return String el Correo electrónico del empleado.
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Método set para Correo electronico del empleado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Método get para la dirección del empleado.
     * @return String la dirección del empleado.
     */
    public String getAddress() {
        return address;
    }

    /** 
     * Método set para la dirección del empleado.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
     * Método get para el número de teléfono del empleado.
     * @return String el número de teléfono del empleado.
     */
    public String getPhone() {
        return phone;
    }

    /** 
     * Método set para el número de teléfono del empleado.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 
     * Devuelve todos los campos de Empleado en un String.
     * @return Los datos del empleado formateado como JSON
     */
    @Override
    public String toString() {
        return "{" + "id=" + getId() + "name=" + getName() + "email=" + getEmail() + "address=" + getAddress()
                + "phone=" + getPhone() + "}";
    }
}
