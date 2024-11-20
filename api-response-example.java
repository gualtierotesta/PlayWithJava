// Generic API response wrapper
public class ApiResponse<T> {
    private T data;
    private String error;
    private boolean success;
    private HttpStatus status;
    
    // Private constructor for use by static factory methods
    private ApiResponse() {}
    
    // Static factory method for success response
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.data = data;
        response.success = true;
        response.status = HttpStatus.OK;
        return response;
    }
    
    // Static factory method for success response with custom status
    public static <T> ApiResponse<T> success(T data, HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.data = data;
        response.success = true;
        response.status = status;
        return response;
    }
    
    // Static factory method for error response
    public static <T> ApiResponse<T> error(String error, HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.error = error;
        response.success = false;
        response.status = status;
        return response;
    }
    
    // Convert to ResponseEntity
    public ResponseEntity<ApiResponse<T>> toResponseEntity() {
        return new ResponseEntity<>(this, this.status);
    }
    
    // Getters
    public T getData() {
        return data;
    }
    
    public String getError() {
        return error;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
}

@RestController
@RequestMapping("/api")
public class UserController {
    
    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        try {
            List<User> users = userService.findAll();
            return ApiResponse.success(users).toResponseEntity();
        } catch (Exception e) {
            return ApiResponse
                .error("Failed to fetch users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)
                .toResponseEntity();
        }
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Long id) {
        try {
            return userService.findById(id)
                .map(user -> ApiResponse.success(user).toResponseEntity())
                .orElseGet(() -> ApiResponse
                    .error("User not found", HttpStatus.NOT_FOUND)
                    .toResponseEntity());
        } catch (Exception e) {
            return ApiResponse
                .error("Failed to fetch user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)
                .toResponseEntity();
        }
    }
}

// Example usage with different status codes
@RestController
@RequestMapping("/api/examples")
public class ExampleController {
    
    @PostMapping("/resource")
    public ResponseEntity<ApiResponse<Resource>> createResource(@RequestBody ResourceDTO dto) {
        try {
            Resource resource = service.create(dto);
            return ApiResponse
                .success(resource, HttpStatus.CREATED)  // Returns 201 Created
                .toResponseEntity();
        } catch (ValidationException e) {
            return ApiResponse
                .error("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST)  // Returns 400 Bad Request
                .toResponseEntity();
        } catch (Exception e) {
            return ApiResponse
                .error("Server error", HttpStatus.INTERNAL_SERVER_ERROR)  // Returns 500 Internal Server Error
                .toResponseEntity();
        }
    }
    
    @DeleteMapping("/resource/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteResource(@PathVariable Long id) {
        try {
            service.delete(id);
            return ApiResponse
                .success(null, HttpStatus.NO_CONTENT)  // Returns 204 No Content
                .toResponseEntity();
        } catch (ResourceNotFoundException e) {
            return ApiResponse
                .error("Resource not found", HttpStatus.NOT_FOUND)  // Returns 404 Not Found
                .toResponseEntity();
        }
    }
}
