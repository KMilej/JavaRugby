/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: ILoginValidation.java
 * Description: Interface for user login authentication.
 */

package interfaces;

import models.Coach;

/**
 * Interface for authenticating a Coach using login credentials.
 */
public interface ILoginValidation {

    /**
     * Authenticates a Coach.
     *
     * @param username coach username
     * @param password coach password
     * @return authenticated Coach or null
     */
    Coach authenticate(String username, String password);
}
