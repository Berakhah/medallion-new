// API endpoints for server communication
const API_ENDPOINTS = {
    customers: '/api/customers',
    shows: '/api/shows',
    reservations: '/reservations',
    tickets: '/api/tickets',
    feedback: '/feedback',
    sales: '/sales',
    discounts: '/discounts',
    performances: '/api/performances',
    loyaltyPrograms: '/api/loyalty',
    memberships: '/api/memberships',
    events: '/api/events',
    seats: '/api/seats'
};

// Function to send requests to the server
function sendRequest(endpoint, method, data = null) {
    const config = {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: data ? JSON.stringify(data) : null
    };
    return fetch(endpoint, config)
        .then(response => response.json().then(data => ({ status: response.status, body: data })))
        .catch(error => console.error('Error:', error));
}

// Customer-related operations
// Register a new customer with the system
function registerCustomer(customerData) {
    return sendRequest(`${API_ENDPOINTS.customers}/register`, 'POST', customerData);
}

// Retrieve detailed information about a customer
function getCustomerDetails(customerId) {
    return sendRequest(`${API_ENDPOINTS.customers}/${customerId}`, 'GET');
}

// Update the information for an existing customer
function updateCustomer(customerId, customerData) {
    return sendRequest(`${API_ENDPOINTS.customers}/${customerId}`, 'PUT', customerData);
}

// Enroll a customer in a loyalty program
function enrollCustomerInLoyaltyProgram(customerId) {
    return sendRequest(`${API_ENDPOINTS.customers}/${customerId}/enroll-loyalty`, 'POST');
}

// Show-related operations
// Add a new show to the system
function createShow(showData) {
    return sendRequest(API_ENDPOINTS.shows, 'POST', showData);
}

// Retrieve a list of all shows from the system
function getAllShows() {
    return sendRequest(API_ENDPOINTS.shows, 'GET');
}

// Get detailed information about a particular show
function getShowDetails(showId) {
    return sendRequest(`${API_ENDPOINTS.shows}/${showId}`, 'GET');
}

// Update the details for an existing show
function updateShow(showId, showData) {
    return sendRequest(`${API_ENDPOINTS.shows}/${showId}`, 'PUT', showData);
}

// Remove a show from the system
function deleteShow(showId) {
    return sendRequest(`${API_ENDPOINTS.shows}/${showId}`, 'DELETE');
}

// Reservation-related operations
// Create a new reservation for tickets
function createReservation(reservationData) {
    return sendRequest(API_ENDPOINTS.reservations, 'POST', reservationData);
}

// Get detailed information about a specific reservation
function getReservation(reservationId) {
    return sendRequest(`${API_ENDPOINTS.reservations}/${reservationId}`, 'GET');
}

// Update details for an existing reservation
function updateReservation(reservationId, reservationData) {
    return sendRequest(`${API_ENDPOINTS.reservations}/${reservationId}`, 'PUT', reservationData);
}

// Cancel and delete an existing reservation
function deleteReservation(reservationId) {
    return sendRequest(`${API_ENDPOINTS.reservations}/${reservationId}`, 'DELETE');
}

// Ticket-related operations
// Issue a ticket for a particular reservation
function issueTicket(ticketData) {
    return sendRequest(API_ENDPOINTS.tickets, 'POST', ticketData);
}

// Retrieve details about a specific ticket
function getTicketDetails(ticketId) {
    return sendRequest(`${API_ENDPOINTS.tickets}/${ticketId}`, 'GET');
}

// Cancel a ticket
function cancelTicket(ticketId) {
    return sendRequest(`${API_ENDPOINTS.tickets}/${ticketId}/cancel`, 'PUT');
}

// Update ticket details
function updateTicket(ticketId, ticketData) {
    return sendRequest(`${API_ENDPOINTS.tickets}/${ticketId}`, 'PUT', ticketData);
}

// Feedback-related operations
// Submit new feedback from a customer
function submitFeedback(feedbackData) {
    return sendRequest(API_ENDPOINTS.feedback, 'POST', feedbackData);
}

// Retrieve all feedback entries from the system
function getAllFeedback() {
    return sendRequest(API_ENDPOINTS.feedback, 'GET');
}

// Update an existing feedback entry
function updateFeedback(feedbackId, feedbackData) {
    return sendRequest(`${API_ENDPOINTS.feedback}/${feedbackId}`, 'PUT', feedbackData);
}

// Sales-related operations
// Record a new sale in the system
function createSale(saleData) {
    return sendRequest(API_ENDPOINTS.sales, 'POST', saleData);
}

// Retrieve detailed information about a specific sale
function getSaleDetails(saleId) {
    return sendRequest(`${API_ENDPOINTS.sales}/${saleId}`, 'GET');
}

// Process a payment for a specific sale
function processSalePayment(saleId) {
    return sendRequest(`${API_ENDPOINTS.sales}/${saleId}/payment`, 'PUT');
}

// Retrieve a list of all sales records
function getAllSales() {
    return sendRequest(API_ENDPOINTS.sales, 'GET');
}

// Discount-related operations
// Create a new discount code in the system
function createDiscount(discountData) {
    return sendRequest(API_ENDPOINTS.discounts, 'POST', discountData);
}

// Apply a discount code to an existing sale
function applyDiscountToSale(saleId, discountCode) {
    return sendRequest(`${API_ENDPOINTS.discounts}/${discountCode}/apply/${saleId}`, 'POST');
}

// Performance-related operations
// Add a new performance to a show
function addPerformance(performanceData) {
    return sendRequest(API_ENDPOINTS.performances, 'POST', performanceData);
}

// Get detailed information about a specific performance
function getPerformanceDetails(performanceId) {
    return sendRequest(`${API_ENDPOINTS.performances}/${performanceId}`, 'GET');
}

// Update the details of an existing performance
function updatePerformance(performanceId, performanceData) {
    return sendRequest(`${API_ENDPOINTS.performances}/${performanceId}`, 'PUT', performanceData);
}

// Remove a performance from the system
function deletePerformance(performanceId) {
    return sendRequest(`${API_ENDPOINTS.performances}/${performanceId}`, 'DELETE');
}

// Retrieve all performances associated with a specific show
function getPerformancesForShow(showId) {
    return sendRequest(`${API_ENDPOINTS.performances}/show/${showId}`, 'GET');
}

// Loyalty Program-related operations
// Register a customer for a new loyalty program
function enrollInLoyaltyProgram(customerId) {
    return sendRequest(`${API_ENDPOINTS.loyaltyPrograms}/enroll/${customerId}`, 'POST');
}

// Event-related operations
// Add a new event to the system
function createEvent(eventData) {
    return sendRequest(API_ENDPOINTS.events, 'POST', eventData);
}

// Membership-related operations
// Create a new membership level in the system
function createMembership(membershipData) {
    return sendRequest(API_ENDPOINTS.memberships, 'POST', membershipData);
}

// Retrieve detailed information about a specific membership
function getMembershipDetails(membershipId) {
    return sendRequest(`${API_ENDPOINTS.memberships}/${membershipId}`, 'GET');
}

// Update the details of an existing membership
function updateMembership(membershipId, membershipData) {
    return sendRequest(`${API_ENDPOINTS.memberships}/${membershipId}`, 'PUT', membershipData);
}

// Seat-related operations
// Update seat availability for a specific performance
function updateSeatAvailability(seatId, isAvailable) {
    return sendRequest(`${API_ENDPOINTS.seats}/${seatId}/availability`, 'PUT', { isAvailable });
}

// Get detailed information about a specific seat
function getSeatDetails(seatId) {
    return sendRequest(`${API_ENDPOINTS.seats}/${seatId}`, 'GET');
}

// Update the details of a specific seat
function updateSeat(seatId, seatData) {
    return sendRequest(`${API_ENDPOINTS.seats}/${seatId}`, 'PUT', seatData);
}

// Get available seats for a specific performance
function getAvailableSeats(performanceId) {
    return sendRequest(`${API_ENDPOINTS.seats}/performance/${performanceId}`, 'GET');
}
