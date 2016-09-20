package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.News;

public class NewsDAO extends AbstractDAO {
	public static final String SELECT_ALL_NEWS = "SELECT * FROM newslist";

	public NewsDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	public List<News> getAll() {

		List<News> lst = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_ALL_NEWS);
			try {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					News mynews = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
					System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) +
							rs.getString(5));
					lst.add(mynews);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps.close();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return lst;

	}
}
