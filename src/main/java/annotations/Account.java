package annotations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    private int acno;
    private String customer;
    private double balance;

    @Id
    @GeneratedValue(  strategy = GenerationType.SEQUENCE,  generator="my_sequence")
    @SequenceGenerator(name="my_sequence",sequenceName="acno_seq", allocationSize=1)
    public int getAcno() {
        return this.acno;
    }
    public void setAcno(int id) {
        this.acno = id;
    }

    @Column(name = "customer", length = 30, nullable = false)
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if (this.acno != other.acno) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return acno;
    }

    @Override
    public String toString() {
        return "annotations.Account[id=" + acno + "]";
    }

    @Column  ( name = "balance", precision = 2, scale = 10)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
