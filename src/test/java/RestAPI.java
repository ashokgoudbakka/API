		
				import io.restassured.RestAssured;
				import io.restassured.http.ContentType;
				import io.restassured.response.Response;
				import org.testng.Assert;
				import org.testng.annotations.Test;

				
					public class RestAPI {
				    @Test
				    public void testLiveEmsTransaction() {
				        // The SOAP request XML
				        String soapRequestPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
				                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				                "xmlns:web=\"http://tempuri.org/\">" +
				                "<soapenv:Header/>" +
				                "<soapenv:Body>" +
				                "<web:liveEmsTransaction>" +
				                "<web:TXN_NAME>GetAttendanceLog</web:TXN_NAME>" +
				                "<web:DATA>" +
				                "<DeviceSlNo>AYSF21075005</DeviceSlNo>" +
				                "<FromDate>2024-12-01</FromDate>" +
				                "<ToDate>2024-12-18</ToDate>" +
				                "</web:DATA>" +
				                "</web:liveEmsTransaction>" +
				                "</soapenv:Body>" +
				                "</soapenv:Envelope>";

				        // Make the request
				        Response response = RestAssured.given()
				                .contentType("text/xml") // Set content type to text/xml for SOAP
				                .accept("text/xml")      // Accept XML response (or application/soap+xml)
				                .header("SOAPAction", "http://tempuri.org/liveEmsTransaction") // Correct SOAPAction header
				                .body(soapRequestPayload) // Set the SOAP XML request body
				                .post("http://103.240.90.194:9222/WebService.asmx"); // Your SOAP web service URL

				        // Print the response body for debugging
				        System.out.println("Response Body: " + response.getBody().asString());

				        // Assert the response status code
				        Assert.assertEquals(response.getStatusCode(), 200); // Assuming 200 OK is the expected status

				        // Optionally: Add further assertions to verify the response content.
				    }
				}

			

	


