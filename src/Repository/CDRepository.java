package Repository;

import Domain.Book;
import Domain.CD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CDRepository implements Repository <Long, CD> {
    private final JdbcUtils jdbcUtils;

    public CDRepository(Properties properties) {
        this.jdbcUtils = new JdbcUtils(properties);
    }

    @Override
    public Optional <CD> addItem(CD entity) {
        String query =  "INSERT INTO book (id, title, author, yearOfPublication, typeOfMusic, numberOfSongs, label, duration,, isLoaned, isReserved) " +
                "VALUES ('" + entity.getId() + "','" + entity.getTitle() + "','" + entity.getAuthor() + "','" + entity.getYearOfPublication() + "','" + entity.getTypeOfMusic()
                + "','" + entity.getNumberOfSongs() + "','" + entity.getLabel() + "','" + entity.getDuration() + "','" + entity.isLoaned()+ "','" + entity.isReserved() + " ');";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.execute();
            return Optional.of(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional <CD> removeItem(Long id) {
        String query1 = "SELECT * FROM cd WHERE id=? ";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(query1)
        ) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional <CD> findItem(Long id) {
        CD cd = new CD();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from cd WHERE id  =?")) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String typeOfMusic = resultSet.getString("typeOfMusic");
                Integer numberOfSongs = Integer.parseInt(resultSet.getString("numberOfSongs"));
                String label = resultSet.getString("label");
                Integer duration =Integer.parseInt(resultSet.getString("duration"));
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                cd =  new CD(yearOfPublication, title, author, typeOfMusic, numberOfSongs, label, duration);
                cd.setId(id1);
                cd.setLoaned(isLoaned);
                cd.setReserved(isReserved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(cd);
    }

    @Override
    public Optional <CD> updateItem(CD entity) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE id=? ")
        ) {
            statement.setLong(1, entity.getId());
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update cd set title=?, author=?, yearOfPublication=?, typeOfMusic=?, numberOfSongs=?, label=?, duration=?, isLoaned=?, isReserved=? where id=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAuthor());
            ps.setInt(3, entity.getYearOfPublication());
            ps.setString(4, entity.getTypeOfMusic());
            ps.setInt(5, entity.getNumberOfSongs());
            ps.setString(6, entity.getLabel());
            ps.setDouble(7, entity.getDuration());
            ps.setString(8, String.valueOf(entity.isLoaned()));
            ps.setString(9, String.valueOf(entity.isReserved()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(entity);
    }

    @Override
    public List<CD> getAllItems() {
        ArrayList<CD> cds = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from cd ")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String typeOfMusic = resultSet.getString("typeOfMusic");
                Integer numberOfSongs = Integer.parseInt(resultSet.getString("numberOfSongs"));
                String label = resultSet.getString("label");
                Integer duration =Integer.parseInt(resultSet.getString("duration"));
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                CD cd= new CD(yearOfPublication,title, author,typeOfMusic, numberOfSongs, label,duration);
                cd.setId(id1);
                cd.setLoaned(isLoaned);
                cd.setReserved(isReserved);
                cds.add(cd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cds;
    }

    public List<CD> findCDsByGenre(String genre) {
        ArrayList<CD>cds = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from cd WHERE genre  =?")) {
            statement.setString(1,genre);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String typeOfMusic = resultSet.getString("typeOfMusic");
                Integer numberOfSongs = Integer.parseInt(resultSet.getString("numberOfSongs"));
                String label = resultSet.getString("label");
                Integer duration =Integer.parseInt(resultSet.getString("duration"));
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                CD cd= new CD(yearOfPublication,title,author,typeOfMusic, numberOfSongs, label,duration);
                cd.setId(id1);
                cd.setLoaned(isLoaned);
                cd.setReserved(isReserved);
               cds.add(cd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cds;
    }
    @Override
    public void loan(String title) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update cd set isLoaned=? where title=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, String.valueOf(true));
            ps.setString(2, title);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnLoan(String title) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update cd set isLoaned=? where title=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, String.valueOf(false));
            ps.setString(2, title);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel(String title) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update cd set isReserved=? where title=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, String.valueOf(false));
            ps.setString(2, title);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reserved(String title) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("CD does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update cd set isReserved=? where title=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, String.valueOf(true));
            ps.setString(2, title);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<CD> getAllLoanCDs() {
        ArrayList<CD> cds = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from cd  where isLoaned='true' ")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication = Integer.parseInt(resultSet.getString("yearOfPublication"));
                String typeOfMusic = resultSet.getString("typeOfMusic");
                Integer numberOfSongs = Integer.parseInt(resultSet.getString("numberOfSongs"));
                String label = resultSet.getString("label");
                Integer duration = Integer.parseInt(resultSet.getString("duration"));
                Boolean isLoaned = Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved = Boolean.parseBoolean(resultSet.getString("isReserved"));

                CD cd = new CD(yearOfPublication, title, author, typeOfMusic, numberOfSongs, label, duration);
                cd.setId(id1);
                cd.setLoaned(isLoaned);
                cd.setReserved(isReserved);
                cds.add(cd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cds;
    }
}
