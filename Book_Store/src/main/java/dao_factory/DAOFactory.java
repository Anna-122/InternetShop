package dao_factory;

//import dao.CityOld;
//import dao.CountriesOld;
//import dao.UsersOld;
//
///**
// * Class created to production of new copies of the desired object

import dao1.BooksService;
import dao1.CitiesService;
import dao1.CountriesService;
import dao1.UserService;

public  class DAOFactory {

    public static UserService getUserService() {
        return new UserService();
    }

    public  static CountriesService getCountriesService() {
        return new CountriesService();
    }

    public static BooksService getBooksService() {
        return new BooksService();
    }

    public static CitiesService getCitiesService() {
        return new CitiesService();
    }


}

//производство новых экземпляров нужного обьекта