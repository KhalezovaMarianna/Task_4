package com.solvd.jdbc;

import com.solvd.classes.Diagnosts;
import com.solvd.classes.Masters;
import com.solvd.dao.IDiagnostDAO;
import com.solvd.dao.IMasterDAO;
import connectionPool.AbstractClassJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DiagnostDAO extends AbstractClassJDBC implements IDiagnostDAO {
    private static final Logger LOGGER = LogManager.getLogger(DiagnostDAO.class);
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Diagnosts d = new Diagnosts();
    private PreparedStatement pr = null;

    @Override
    public List<Diagnosts> getAllDiagnosts() {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Diagnosts");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                d.setIdDiagnosts(resultSet.getInt("2"));
                d.setName(resultSet.getString("name"));
                d.setFirstName(resultSet.getString("firstName"));
                d.setTelefonNumber(resultSet.getString("telefonNumber"));
                LOGGER.info(d);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);

            }
        }
        return getAllDiagnosts();
    }

    @Override
    public Diagnosts getEntityById(int id) throws SQLException {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Diagnosts  where id=?");
            pr.setInt(1, id);
            pr.execute();
            LOGGER.info("it is a select");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return getEntityById(1);
    }


    @Override
    public void createEntity(Diagnosts entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into Diagnosts(firstName) values (?)");
            resultSet = pr.getResultSet();
            pr.setInt(1, resultSet.getInt("firstName"));
            pr.execute();
            LOGGER.info("has been insert");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Diagnosts entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update Diagnosts set name=?,firstName=?,telefonNumber=? where id=?");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getFirstName());
            pr.setString(3, entity.getTelefonNumber());
            pr.setInt(4, entity.getIdDiagnosts());
            pr.executeUpdate();
            LOGGER.info("Diagnosts data has been update");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(Diagnosts entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from Diagnosts where id=?");
            pr.setInt(1, entity.getIdDiagnosts());
            pr.executeUpdate();
            LOGGER.info("Diagnosts data has been delete");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }

    }

}

