package com.example.producer

import com.example.producer.model.dto.TaskDTO
import com.example.producer.model.dto.UserDTO
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerSpec extends Specification {

    private static TaskDTO dto1 = new TaskDTO(1, "test", true, null, null)
    private static TaskDTO dto2 = new TaskDTO(2, "test2", false, 20, new UserDTO(1, 'Jan', 'Kowalski', 'jk@wp.pl'))
    private static List<TaskDTO> dtos = [dto1, dto2]

    @Autowired
    MockMvc mvc
    private ObjectMapper objectMapper = new ObjectMapper()

    def "should return list of Tasks"(){
        when: "getting values from database by using endpoind /api/tasks"
        def result = mvc.perform(get("/api/tasks")).andReturn()
        def values = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<TaskDTO>>() {})
        then:
        values.get(0) == dtos.get(0)
        values.get(1) == dtos.get(1)
        values.containsAll(dtos)
    }

}
