package javacode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Board2DAO {

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
