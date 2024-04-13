
import java.sql.Timestamp;

public class test {
    public static void main(String[] args) {
        DTO.PhieuNhapDTO pn = new DTO.PhieuNhapDTO(1, 110, 1,new Timestamp(System.currentTimeMillis()), 10000);
        DAO.PhieuNhapDAO pnd= new DAO.PhieuNhapDAO();
       // pnd.insert(pn);
        System.out.println(pnd.selectById(110).toString());
        //System.out.println(new Timestamp(System.currentTimeMillis()));
        
    }
}
