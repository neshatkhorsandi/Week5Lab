/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getItems(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getItems(request,response);
    }
    
    public void getItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String userName = request.getParameter("user");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
       if(userName != null && !userName.isEmpty())
        {
            session.setAttribute("username",userName);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            return;
        }
        if(action  == null || action.isEmpty())
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                 forward(request, response);
        }
     
        ArrayList<String> shoppingList = (ArrayList<String>) session.getAttribute("shoppingList");
        
        if(shoppingList == null)
        {
            shoppingList = new ArrayList();
        }
        switch(action)
        {
            case "register":
                    session.setAttribute("username",userName);
                    response.sendRedirect("shoppingList");
            
            break;
            case "add": 
                    String items = request.getParameter("addToList");
                    shoppingList.add(items);
                    //request.setAttribute("shoppingList", shoppingList);
                    session.setAttribute("shoppingList", shoppingList);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                    forward(request, response);
            break;
            case "delete":
                
                for(int i = 0; i<shoppingList.size();i++)
                {
                    shoppingList.remove(i);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                forward(request, response);
            case "logout":   
                
                   String loggedOut = "You successfully logged out";
                   session.removeAttribute("username");
                   session.invalidate();
                   request.setAttribute("successfulLogOut",loggedOut);
                  
                   getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                 forward(request, response);
                   
        } 
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                 forward(request, response);
        
    }
}
