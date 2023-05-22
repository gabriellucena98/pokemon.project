package backend.pokemon.project.repository.mapper

import backend.pokemon.project.domain.UserMaster
import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

class UserMapper: RowMapper<UserMaster> {
    override fun mapRow(rs: ResultSet, rowNum: Int): UserMaster {
        return UserMaster(
            id = rs.getLong("id"),
            username = rs.getString("username"),
            email = rs.getString("email"),
            password = rs.getString("password"),
            image = rs.getString("image")
        )
    }
}