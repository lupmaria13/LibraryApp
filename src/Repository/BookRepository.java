package Repository;

import Domain.Book;
import Domain.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class BookRepository implements Repository <Long,Book> {
    private final JdbcUtils jdbcUtils;

    public BookRepository(Properties properties) {
        this.jdbcUtils = new JdbcUtils(properties);
    }

    @Override
    public Optional <Book> addItem(Book entity) {
        String query =  "INSERT INTO book (id, title, author, yearOfPublication, type, numberOfPages, color, isLoaned, isReserved) " +
                "VALUES ('" + entity.getId() + "','" + entity.getTitle() + "','" + entity.getAuthor() + "','" + entity.getYearOfPublication() + "','" + entity.getType()
                + "','" + entity.getNumberOfPages() + "','" + entity.getColor() + "','" + entity.isLoaned()+ "','" + entity.isReserved() + " ');";
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
    public Optional<Book> findItem(Long id) {
       Book book = new Book();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book WHERE id  =?")) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(book);
    }


    @Override
    public Optional <Book> removeItem(Long id) {
        String query1 = "SELECT * FROM book WHERE id=? ";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(query1)
        ) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public List<Book> findByAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book WHERE author  =?")) {
            statement.setString(1,author);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void loan(String title) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update book set isLoaned=? where title=?";
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
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update book set isLoaned=? where title=?";
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
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update book set isReserved=? where title=?";
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
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE title=? ")
        ) {
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update book set isReserved=? where title=?";
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
    public List<Book> findByTitle(String title) {
        ArrayList<Book> books = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book WHERE title  =?")) {
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Optional <Book> updateItem(Book entity) {
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE id=? ")
        ) {
            statement.setLong(1, entity.getId());
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RepositoryException("Book does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update book set title=?, author=?, yearOfPublication=?, type=?, numberOfPages=?, color=?, isLoaned=?, isReserved=? where id=?";
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAuthor());
            ps.setInt(3, entity.getYearOfPublication());
            ps.setString(4, entity.getType());
            ps.setInt(5, entity.getNumberOfPages());
            ps.setString(6, entity.getColor());
            ps.setString(7, String.valueOf(entity.isLoaned()));
            ps.setString(7, String.valueOf(entity.isReserved()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(entity);
    }

    @Override
    public List<Book> getAllItems() {
        ArrayList<Book> books = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book ")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public List<Book> getAllLoanBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book where isLoaned='true' ")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


//    public void loanBook(String title) {
//        try (
//                Connection connection = jdbcUtils.getConnection();
//                PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE title=? ")
//        ) {
//            statement.setString(1, title);
//            ResultSet rs = statement.executeQuery();
//            if (!rs.next())
//                throw new RepositoryException("Book does not exist!");
//            if ( )
//                Long id1 = Long.parseLong(rs.getString("id"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        String sql = "update book set title=?, author=?, yearOfPublication=?, type=?, numberOfPages=?, color=?, isLoaned=?, isReserved=? where id=?";
//        try (
//                Connection connection = jdbcUtils.getConnection();
//                PreparedStatement ps = connection.prepareStatement(sql)
//        ) {
//            ps.setString(1, entity.getTitle());
//            ps.setString(2, entity.getAuthor());
//            ps.setInt(3, entity.getYearOfPublication());
//            ps.setString(4, entity.getType());
//            ps.setInt(5, entity.getNumberOfPages());
//            ps.setString(6, entity.getColor());
//            ps.setString(7, String.valueOf(entity.isLoaned()));
//            ps.setString(7, String.valueOf(entity.isReserved()));
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.of(entity);
//    }
//
//    public void returnBook(String title) {
//        for (Book book : bookList) {
//            if (book.getTitle().equalsIgnoreCase(title) && book.isLoaned()) {
//                book.setLoaned(false);
//                System.out.println("Book has been returned: " + title);
//                return;
//            }
//        }
//        System.out.println("Book was not loaned: " + title);
//    }
//    public void reserveBook(String title) {
//        for (Book book : bookList) {
//            if (book.getTitle().equalsIgnoreCase(title) && !book.isReserved()) {
//                book.setReserved(true);
//                System.out.println("Book has been reserved: " + title);
//                return;
//            }
//        }
//        System.out.println("Book is already reserved or not found: " + title);
//    }

    public List<Book> getallloanbooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (
                Connection connection = jdbcUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * from book WHERE isLoaned  =?")) {
            statement.setString(1,"true");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id1 = Long.parseLong(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Integer yearOfPublication =Integer.parseInt(resultSet.getString("yearOfPublication"));
                String type = resultSet.getString("type");
                Integer numberOfPages = Integer.parseInt(resultSet.getString("numberOfPages"));
                String color = resultSet.getString("color");
                Boolean isLoaned =Boolean.parseBoolean(resultSet.getString("isLoaned"));
                Boolean isReserved =Boolean.parseBoolean(resultSet.getString("isReserved"));

                Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
                book.setId(id1);
                book.setLoaned(isLoaned);
                book.setReserved(isReserved);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
