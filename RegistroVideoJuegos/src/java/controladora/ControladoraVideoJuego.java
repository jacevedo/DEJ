/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import entidades.VideoJuego;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */
public class ControladoraVideoJuego 
{
    private Connection cnx;
    
    public ControladoraVideoJuego(Connection cnx)
    {
        this.cnx = cnx;
    }
    
    public void agregarVideoJuego(VideoJuego videoJuego) 
    {
        String sql = "insert into video_juego (id, nombre, precio, tipo)"
                + "values (null, ?, ?, ?)";
        
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, videoJuego.getNombre());
            stmt.setInt(2, videoJuego.getPrecio());
            stmt.setString(3, videoJuego.getTipo());
            
            stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ControladoraVideoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public VideoJuego obtenerVideoJuegoPorId(int id)
    {
        VideoJuego videoJuego = null;
        String sql = "select * from video_juego where id = ?";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    videoJuego = new VideoJuego();
                    videoJuego.setId(rs.getInt("id"));
                    videoJuego.setNombre(rs.getString("nombre"));
                    videoJuego.setPrecio(rs.getInt("precio"));
                    videoJuego.setTipo(rs.getString("tipo"));
                }
            }
        }
        catch(SQLException ex)
        {
            
        }
        return videoJuego;
    }
    public void eliminarVideoJuegoPorId(int id)
    {
        String sql = "delete from video_juego where id = ?";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ControladoraVideoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarVideoJuego(VideoJuego videoJuego)
    {
        String sql = "update video_juego "
                            + "set nombre = ?,"
                            + " precio = ?, "
                            + " tipo = ?"
                            + " where id = ?";
        
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, videoJuego.getNombre());
            stmt.setInt(2, videoJuego.getPrecio());
            stmt.setString(3, videoJuego.getTipo());
            stmt.setInt(4, videoJuego.getId());
            
            stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ControladoraVideoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<VideoJuego> listarVideoJuegos()
    {
        ArrayList<VideoJuego> listaVideoJuego = new ArrayList<>();
        String sql = "select * from video_juego";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    VideoJuego videoJuego = new VideoJuego();
                    videoJuego.setId(rs.getInt("id"));
                    videoJuego.setNombre(rs.getString("nombre"));
                    videoJuego.setPrecio(rs.getInt("precio"));
                    videoJuego.setTipo(rs.getString("tipo"));
                    listaVideoJuego.add(videoJuego);
                }
            }
        }
        catch(SQLException ex)
        {
            
        }
        
        return listaVideoJuego;
    }
}
