INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (100, 'The server has received the request headers and the client should proceed to send the request body (in the case of a request for which a body needs to be sent; for example, a POST request). Sending a large request body to a server after a request has been rejected for inappropriate headers would be inefficient. To have a server check the request''s headers, a client must send Expect: 100-continue as a header in its initial request and receive a 100 Continue status code in response before sending the body. If the client receives an error code such as 403 (Forbidden) or 405 (Method Not Allowed) then it shouldn''t send the request''s body. The response 417 Expectation Failed indicates that the request should be repeated without the Expect header as it indicates that the server doesn''t support expectations (this is the case, for example, of HTTP/1.0 servers).', 'Continue',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (101, 'The requester has asked the server to switch protocols and the server has agreed to do so.', 'Switching Protocols',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (102, 'A WebDAV request may contain many sub-requests involving file operations, requiring a long time to complete the request. This code indicates that the server has received and is processing the request, but no response is available yet. This prevents the client from timing out and assuming the request ', 'Processing',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (103, 'Used to return some response headers before final HTTP message.', 'Early Hints',1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (200, 'Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.', 'OK',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (201, 'The request has been fulfilled, resulting in the creation of a new resource.', 'Created',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (202, 'The request has been accepted for processing, but the processing has not been completed. The request might or might not be eventually acted upon, and may be disallowed when processing occurs.', 'Accepted',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (203, 'The server is a transforming proxy (e.g. a Web accelerator) that received a 200 OK from its origin, but is returning a modified version of the origin''s response.', 'Non-Authoritative Information',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (204, 'The server successfully processed the request and is not returning any content.', 'No Content',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (205, 'The server successfully processed the request, but is not returning any content. Unlike a 204 response, this response requires that the requester reset the document view.', 'Reset Content',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (206, 'The server is delivering only part of the resource (byte serving) due to a range header sent by the client. The range header is used by HTTP clients to enable resuming of interrupted downloads, or split a download into multiple simultaneous streams.', 'Partial Content',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (207, 'The message body that follows is by default an XML message and can contain a number of separate response codes, depending on how many sub-requests were made.', 'Multi-Status',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (208, 'The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.', 'Already Reported',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (226, 'The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.', 'IM Used', 'https://tools.ietf.org/html/rfc3229',1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (300, 'Indicates multiple options for the resource from which the client may choose (via agent-driven content negotiation). For example, this code could be used to present multiple video format options, to list files with different filename extensions, or to suggest word-sense disambiguation.', 'Multiple Choices',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (301, 'This and all future requests should be directed to the given URI.', 'Moved Permanently',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (302, 'Tells the client to look at (browse to) another url. 302 has been superseded by 303 and 307. This is an example of industry practice contradicting the standard. The HTTP/1.0 specification (RFC 1945) required the client to perform a temporary redirect (the original describing phrase was "Moved Temporarily"), but popular browsers implemented 302 with the functionality of a 303 See Other. Therefore, HTTP/1.1 added status codes 303 and 307 to distinguish between the two behaviours. However, some Web applications and frameworks use the 302 status code as if it were the 303.', 'Found (Previously "Moved temporarily")',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (303, 'The response to the request can be found under another URI using the GET method. When received in response to a POST (or PUT/DELETE), the client should presume that the server has received the data and should issue a new GET request to the given URI.', 'See Other',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (304, 'Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-None-Match. In such case, there is no need to retransmit the resource since the client still has a previously-downloaded copy.', 'Not Modified', 'https://tools.ietf.org/html/rfc7232',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (305, 'The requested resource is available only through a proxy, the address for which is provided in the response. Many HTTP clients (such as Mozilla and Internet Explorer) do not correctly handle responses with this status code, primarily for security reasons.', 'Use Proxy (since HTTP/1.1)',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (306, 'No longer used. Originally meant "Subsequent requests should use the specified proxy."', 'Switch Proxy',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (307, 'In this case, the request should be repeated with another URI; however, future requests should still use the original URI. In contrast to how 302 was historically implemented, the request method is not allowed to be changed when reissuing the original request. For example, a POST request should be repeated using another POST request.', 'Temporary Redirect (since HTTP/1.1)',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (308, 'The request and all future requests should be repeated using another URI. 307 and 308 parallel the behaviors of 302 and 301, but do not allow the HTTP method to change. So, for example, submitting a form to a permanently redirected resource may continue smoothly.', 'Permanent Redirect', 'https://tools.ietf.org/html/rfc7538',1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (400, 'The server cannot or will not process the request due to an apparent client error (e.g., malformed request syntax, size too large, invalid request message framing, or deceptive request routing).', 'Bad Request',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (401, 'Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided. The response must include a WWW-Authenticate header field containing a challenge applicable to the requested resource. See Basic access authentication and Digest access authentication. 401 semantically means "unauthenticated", i.e. the user does not have the necessary credentials.', 'Unauthorized', 'https://tools.ietf.org/html/rfc7235',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (402, 'Reserved for future use. The original intention was that this code might be used as part of some form of digital cash or micropayment scheme, as proposed for example by GNU Taler, but that has not yet happened, and this code is not usually used. Google Developers API uses this status if a particular developer has exceeded the daily limit on requests. Sipgate uses this code if an account does not have sufficient funds to start a call. Shopify uses this code when the store has not paid their fees and is temporarily disabled.', 'Payment Required',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (403, 'The request was valid, but the server is refusing action. The user might not have the necessary permissions for a resource, or may need an account of some sort.', 'Forbidden',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (404, 'The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible.', 'Not Found',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (405, 'A request method is not supported for the requested resource; for example, a GET request on a form that requires data to be presented via POST, or a PUT request on a read-only resource.', 'Method Not Allowed',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (406, 'The requested resource is capable of generating only content not acceptable according to the Accept headers sent in the request. See Content negotiation.','Not Acceptable',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (415,'The request entity has a media type which the server or resource does not support. For example, the client uploads an image as image/svg+xml, but the server requires that images use a different format.','Unsupported Media Type',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (416,'The client has asked for a portion of the file (byte serving), but the server cannot supply that portion. For example, if the client asked for a part of the file that lies beyond the end of the file. Called "Requested Range Not Satisfiable" previously.','Range Not Satisfiable','https://tools.ietf.org/html/rfc7233',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (417,'The server cannot meet the requirements of the Expect request-header field.','Expectation Failed',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (418,'This code was defined in 1998 as one of the traditional IETF April Fools'' jokes, in RFC 2324, Hyper Text Coffee Pot Control Protocol, and is not expected to be implemented by actual HTTP servers. The RFC specifies this code should be returned by teapots requested to brew coffee. This HTTP status is used as an Easter egg in some websites, including Google.com.','Im a Teapot','https://tools.ietf.org/html/rfc7168',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (421,'The request was directed at a server that is not able to produce a response (for example because of connection reuse)','Misdirected Redirect','https://tools.ietf.org/html/rfc7540',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (422,'The request was well-formed but was unable to be followed due to semantic errors.','Unprocessable Entity','https://tools.ietf.org/html/rfc4918',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (423,'The resource that is being accessed is locked.','Locked','https://tools.ietf.org/html/rfc4918',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (424,'The request failed because it depended on another request and that request failed (e.g., a PROPPATCH).','Failed Dependency','https://tools.ietf.org/html/rfc4918',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (426,'The client should switch to a different protocol such as TLS/1.0, given in the Upgrade header field.','Upgrade Required',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (428,'The origin server requires the request to be conditional. Intended to prevent the ''lost update'' problem, where a client GETs a resource''s state, modifies it, and PUTs it back to the server, when meanwhile a third party has modified the state on the server, leading to a conflict.','Precondition Required','https://tools.ietf.org/html/rfc6585',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (429,'The user has sent too many requests in a given amount of time. Intended for use with rate-limiting schemes.','Precondition Required','https://tools.ietf.org/html/rfc6585',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (431,'The server is unwilling to process the request because either an individual header field, or all the header fields collectively, are too large.','Request Header Fields Too Large','https://tools.ietf.org/html/rfc6585',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (451,'A server operator has received a legal demand to deny access to a resource or to a set of resources that includes the requested resource. The code 451 was chosen as a reference to the novel Fahrenheit 451 (see the Acknowledgements in the RFC).','Unavailable for Legal Reasons','https://tools.ietf.org/html/rfc7725',1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (500,'A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.','Internal Server Error',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (501,'The server either does not recognize the request method, or it lacks the ability to fulfil the request. Usually this implies future availability (e.g., a new feature of a web-service API).','Not Implemented',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (502,'The server was acting as a gateway or proxy and received an invalid response from the upstream server.','Bad Gateway',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (503,'The server is currently unavailable (because it is overloaded or down for maintenance). Generally, this is a temporary state.','Service Unavailable',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (504,'The server was acting as a gateway or proxy and did not receive a timely response from the upstream server.','Gateway Timeout',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (505,'The server does not support the HTTP protocol version used in the request.','HTTP Version not Supported',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (506,'Transparent content negotiation for the request results in a circular reference.','Variant Also Negotiates','https://tools.ietf.org/html/rfc2295',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (507,'The server is unable to store the representation needed to complete the request.','Insufficient Storage','https://tools.ietf.org/html/rfc4918',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (508,'The server detected an infinite loop while processing the request (sent in lieu of 208 Already Reported)','Loop Detected','https://tools.ietf.org/html/rfc5842',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (510,'Further extensions to the request are required for the server to fulfill it.','Not Extended','https://tools.ietf.org/html/rfc2774',1);
INSERT INTO public.sc_status_code (status_code, long_description, short_description, rfc_uri, status_code_type_id) VALUES (511,'The client needs to authenticate to gain network access. Intended for use by intercepting proxies used to control access to the network (e.g., "captive portals" used to require agreement to Terms of Service before granting full Internet access via a Wi-Fi hotspot).','Network Authentication Required','https://tools.ietf.org/html/rfc6585',1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (666,'Let the one with understanding reckon the meaning of the number of the beast, for it is the number of a man.','The Number of Man',2);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (103,'Used in the resumable requests proposal to resume aborted PUT or POST requests.','Checkpoint',2);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (218,'Used as a catch-all error condition for allowing response bodies to flow through Apache when ProxyErrorOverride is enabled. When ProxyErrorOverride is enabled in Apache, response bodies that contain a status code of 4xx or 5xx are automatically discarded by Apache in favor of a generic response or a custom response specified by the ErrorDocument directive.','This is fine',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=218 AND short_description='This is fine'),1);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (419,'Used by the Laravel Framework when a CSRF Token is missing or expired.','Page Expired',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=419),2);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (420,'A deprecated response used by the Spring Framework when a method has failed.','Method Failure',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=420 AND short_description='Method Failure'),3);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (420,'Returned by version 1 of the Twitter Search and Trends API when the client is being rate limited; versions 1.1 and later use the 429 Too Many Requests response code instead.','Enhance Your Calm',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=420 AND short_description='Enhance Your Calm'),4);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (497,'An expansion of the 400 Bad Request response code, used when the client has made a HTTP request to a port listening for HTTPS request.','HTTP Request Sent to HTTPS Port',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=497),11);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (509,'The server has exceeded the bandwidth specified by the server administrator; this is often used by shared hosting providers to limit the bandwidth of customers.','Bandwidth Limit Exceeded',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=509),1);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=509),5);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (526,'Used by Cloudflare and Cloud Foundry''s gorouter to indicate failure to validate the SSL/TLS certificate that the origin server presented.','Invalid SSL Certificate',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=526),7);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=526),8);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (520,'The 520 error is used as a "catch-all response for when the origin server returns something unexpected", listing connection resets, large headers, and empty or invalid responses as common triggers.','Unknown Error',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=520),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (521,'The origin server has refused the connection from Cloudflare.','Web Server Is Down',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=521),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (522,'Cloudflare could not negotiate a TCP handshake with the origin server.','Connection Timed Out',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=522),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (523,'Cloudflare could not reach the origin server; for example, if the DNS records for the origin server are incorrect.','Origin Is Unreachable',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=523),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (524,'Cloudflare was able to complete a TCP connection to the origin server, but did not receive a timely HTTP response.','A Timeout Occurred',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=524),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (525,'Cloudflare could not negotiate a SSL/TLS handshake with the origin server.','SSL Handshake Failed',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=525),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (526,'Cloudflare could not validate the SSL certificate on the origin web server.','Invalid SSL Certificate',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=526),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (527,'Error 527 indicates that the request timed out or failed after the WAN connection had been established.','Railgun Error',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=527),7);

INSERT INTO public.sc_status_code (status_code, long_description, short_description, status_code_type_id) VALUES (530,'Error 530 indicates that the requested host name could not be resolved on the Cloudflare network to an origin server.','Origin DNS Error',2);
INSERT INTO public.sc_software_status_code(status_code_id, software_id) VALUES ((SELECT status_code_id from public.sc_status_code WHERE status_code=530),7);
