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
        stubFor(get(urlPathEqualTo("/rate"))
                .withQueryParam("from", equalTo("USD"))
                .withQueryParam("to", equalTo("TRY"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("34.567")));

        double rate = client.rate("USD", "TRY");
        assertEquals(34.567, rate, 0.001);
    }

    @Test
    @DisplayName("404 -> RuntimeException wrapping IllegalArgumentException")
    void notFound404() {
        stubFor(get(urlPathEqualTo("/rate"))
                .withQueryParam("from", equalTo("USD"))
                .withQueryParam("to", equalTo("XXX"))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withBody("unsupported currency")));

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> client.rate("USD", "XXX"));

        assertTrue(ex.getCause() instanceof IllegalArgumentException);
        assertEquals("unsupported currency", ex.getCause().getMessage());
    }

    @Test
    @DisplayName("500 -> RuntimeException wrapping IllegalStateException")
    void server500() {
        stubFor(get(urlPathEqualTo("/rate"))
                .willReturn(aResponse().withStatus(500)));

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> client.rate("USD", "TRY"));

        assertTrue(ex.getCause() instanceof IllegalStateException);
        assertTrue(ex.getCause().getMessage().contains("remote error: 500"));
    }

    @Test
    @DisplayName("fault/malformed -> RuntimeException cause present")
    void faultOrMalformed() {
        stubFor(get(urlPathEqualTo("/rate"))
                .willReturn(aResponse().withFault(Fault.MALFORMED_RESPONSE_CHUNK)));

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> client.rate("USD", "TRY"));

        assertNotNull(ex.getCause());
    }
}
