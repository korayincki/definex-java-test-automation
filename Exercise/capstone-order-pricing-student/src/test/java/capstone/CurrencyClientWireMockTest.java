package capstone;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.Fault;
import org.junit.jupiter.api.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Student skeleton – WireMock tests for CurrencyClient.
 */
@DisplayName("CurrencyClient WireMock tests (student skeleton)")
class CurrencyClientWireMockTest {

    static WireMockServer wm;
    CurrencyClient client;

    @BeforeAll
    static void beforeAll() {
        wm = new WireMockServer(0);
        wm.start();
        configureFor("localhost", wm.port());
    }

    @AfterAll
    static void afterAll() { if (wm != null) wm.stop(); }

    @BeforeEach
    void setUp() {
        wm.resetAll();
        client = new CurrencyClient(wm.baseUrl());
    }

    @Test
    @DisplayName("200 -> returns rate")
    void ok200() {
        // stub 200 with body "34.567", call client.rate, assert ~34.567
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("404 -> RuntimeException wrapping IllegalArgumentException")
    void notFound404() {
        // stub 404, assert RuntimeException with cause type/message
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("500 -> RuntimeException wrapping IllegalStateException")
    void server500() {
        // stub 500, assert RuntimeException with cause type/message
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("fault/malformed -> RuntimeException cause present")
    void faultOrMalformed() {
        // e.g., withFault(CONNECTION_RESET_BY_PEER) or body "oops"
        throw new UnsupportedOperationException("implement");
    }
}
