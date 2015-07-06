/*******************************************************************************
 * Copyright 2015 xWic group (http://www.xwic.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *  
 *******************************************************************************/
package de.jwic.maildemo.api;

/**
 * Provides access to the mail server.
 * 
 * @author Florian Lippisch
 */
public interface IMailServer {

	/**
	 * Logon with the users name and password. Returns a ISession object
	 * for further operations or throws an AuthenticationFailedException
	 * if the authentication failed.
	 * @param username
	 * @param password
	 * @return
	 * @throws AuthenticationFailedException
	 */
	public ISession logon(String username, String password) throws AuthenticationFailedException;
	
	/**
	 * Returns the mail by ID.
	 * @param username
	 * @param uniqueID
	 * @return
	 */
	public IMail getMailByID(String username, String uniqueID);
	
}
