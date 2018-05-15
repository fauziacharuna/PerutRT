/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;
//pattern MVC selanjutnya adalah packages model
//dimana nantinya dalam packages ini kita mengetahui cara memisahkan data

import dao.*;
import dao.implementUser;

public abstract class DAOFactory {
    //class ini adalah abstract interface dari DAO dimana disini nantinya
    //setiap kode dipisah berdasarkan fungsinya masing2
    //sehingga kode lain diatasnya tidak perlu tahu cara pengaksesan
    //ke sumber data yang diimplementasikan.
    public static final int MySql = 0;
    public static final int REST = 1;
    public static DAOFactory getFactory (Integer type){
        switch (type){
            case MySql: 
                return new MySqlDAOFactory();
            case REST: 
                return new RESTDAOFactory();
            default:
                return null;
        }
    }
}
