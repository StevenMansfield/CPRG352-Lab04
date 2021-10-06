package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 786821
 */
public class NoteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
        BufferedReader br = new BufferedReader(new FileReader(new File(path))); 
        String title = br.readLine(); 
        String contents = br.readLine().trim(); 
        Note filledNote = new Note(title, contents); 
        String edit = request.getParameter("edit");
        if (edit == null) {
            request.setAttribute("note", filledNote);
            br.close(); 
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
            return;
        } else {
            request.setAttribute("note", filledNote);
            br.close(); 
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
            return;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        String title = "";
        String contents = "";
        
        title = request.getParameter("title"); 
        contents = request.getParameter("contents");
        
        Note filledNote = new Note(title, contents); 
        
        request.setAttribute("note", filledNote);
        pw.println(title);
        pw.print(contents);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        return;
    }
}
