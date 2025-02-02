import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.evaluation.Application;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;
import com.user.evaluation.enums.MonthEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EvaluationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Try-with-resources is for automatically closing resources after use.
     * Testcontainers doesn't need it because JUnit/Testcontainers manages the container lifecycle
     */
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:14")
                    .withDatabaseName("evaluationsDb")
                    .withUsername("postgres")
                    .withPassword("postgres");


    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        propertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        propertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @Test
    void testContainerRunning() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }

    @Test
    void givenData_saveEvaluation() throws Exception {
        UserEvaluationModel evaluationRequest = getEvaluationRequest();
        String requestJson = objectMapper.writeValueAsString(evaluationRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/evaluations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().is(200));
    }

    private UserEvaluationModel getEvaluationRequest() {
        return UserEvaluationModel.builder()
                .evaluationComment("Such good employee")
                .month(MonthEnum.JANUARY)
                .userModel(UserModel.builder().id(1L).build())
                .build();
    }
}
