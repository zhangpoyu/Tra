package come.poyu.servlet;


import come.poyu.dao.CarDao;
import come.poyu.dao.impl.CarDaoImpl;
import come.poyu.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/jsp/manager/carInfo/CarInformation")
public class CarInformation extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
       Car car = new Car();
        CarDao carDao = new CarDaoImpl();
        PrintWriter out = resp.getWriter();
        List<Car> list = carDao.getAll();
        req.setAttribute("cars",list);
        out.print(list);
        req.getRequestDispatcher("CarInf.jsp").forward(req,resp);
    }
}
