package javacode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Board2DAO {

    public static int delBoard2(int iboard)
    {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "delete from t_board2 where iboard =?";

        try{
            con = Dbutils.getCon();
            ps=con.prepareStatement(sql);
            ps.setInt(1,iboard);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Dbutils.close(con,ps);
        }

        return 0;
    }

    public static int insBoard2(Board2VO param)
    {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "insert into t_board2 (title,ctnt,writer) values (?,?,?)";

        try{
            con = Dbutils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,param.getTitle());
            ps.setString(2,param.getCtnt());
            ps.setString(3,param.getWriter());
            return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            Dbutils.close(con,ps);
        }

        return 0;
    }

    public static Board2VO selBoard2Detail(Board2VO param) {
        Board2VO vo = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs= null;

        String sql = "select iboard,title,ctnt,writer,rdt from t_board2 where iboard=?";

        try {
            con = Dbutils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();

            if(rs.next())
            {
                vo = new Board2VO();
                vo.setIboard(param.getIboard());
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            Dbutils.close(con,ps,rs);
        }
            return vo;
    }

    public static List<Board2VO> selBoard2List()
    {
        List<Board2VO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select iboard,title,ctnt,writer,rdt from t_board2";

        try{
            con = Dbutils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Board2VO vo = new Board2VO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Dbutils.close(con,ps,rs);
        }

        return list;

    }
}
