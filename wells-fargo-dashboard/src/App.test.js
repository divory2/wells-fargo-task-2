import { render, screen, waitFor } from '@testing-library/react';
import App from './App';
import userEvent from '@testing-library/user-event'
import axios from 'axios';
// import axios from 'axios';
jest.mock('axios');
describe('Testing the login screen', () => {
  beforeEach( () => {
      render(<App/>);
  });
test('renders Dash Board Title', () => {

  const dashboardTitle = screen.getByText(/Dash Board Login/i);
  expect(dashboardTitle).toBeInTheDocument();
});
test('checks if email exists', async () => {

  const email = await screen.findByRole('textbox', {name: /email/i });
  expect(email).toBeInTheDocument();
});
test('checks if password exists', async () => {

  const password = await screen.findByRole('textbox', {name: /password/i });
  expect(password).toBeInTheDocument();
});
test('check email field valadation', async () => {
  const userEmail = "devonivory27@gmail.com";
  const email = await screen.findByRole('textbox', {name: /email/i });
   await userEvent.type(email, userEmail);
   expect(email.value).toBe(userEmail);
});
test('check password field valadation', async () => {
  const userPassword = "dsdfws";
  const password = await screen.findByRole('textbox', {name: /email/i });
   await userEvent.type(password, userPassword);
   expect(password.value).toBe(userPassword);
});
test('When submit button is pressed and fields both fields are empty', async () => {
  window.alert = jest.fn();
  
  const loginButton = await screen.findByRole('button', {name: /login/i });
   await userEvent.click(loginButton);
  expect(window.alert).toHaveBeenCalled();

   
});
test('When submit button is pressed and password fields has value and email field is empty', async () => {
  window.alert = jest.fn();
  
  const loginButton = await screen.findByRole('button', {name: /login/i });
  const userPassword = "dsdfws";
  const password = await screen.findByRole('textbox', {name: /password/i });
   await userEvent.type(password, userPassword);
   await userEvent.click(loginButton);
  expect(window.alert).toHaveBeenCalledWith("Constraints not satisfied: email ")
  expect(window.alert).toHaveBeenCalledTimes(1);
  alert.mockRestore();

  // Please fill out this field.: email Please fill out this field.: password
});
test('When submit button is pressed and password fields empty and email field is has proper email format', async () => {
  window.alert = jest.fn();
  
  const loginButton = await screen.findByRole('button', {name: /login/i });
  const userEmail = "devonivory27@gmail.com";
  const email = await screen.findByRole('textbox', {name: /email/i });
   await userEvent.type(email,userEmail);
   await userEvent.click(loginButton);
  expect(window.alert).toHaveBeenCalledWith(" Constraints not satisfied: password");
  expect(window.alert).toHaveBeenCalledTimes(1);
  alert.mockRestore();

  // Please fill out this field.: email Please fill out this field.: password
});
test('When submit button is pressed and password fields has a value  and email field does not have proper email format', async () => {
  window.alert = jest.fn();
  
  const loginButton = await screen.findByRole('button', {name: /login/i });
  const userEmail = "devonivory27gmail.com";
  const userPassword = "dsdfws";
  const password = await screen.findByRole('textbox', {name: /password/i });
   await userEvent.type(password, userPassword);
  const email = await screen.findByRole('textbox', {name: /email/i });
   await userEvent.type(email,userEmail);
   await userEvent.click(loginButton);
  expect(window.alert).toHaveBeenCalledWith("Constraints not satisfied: email ");
  expect(window.alert).toHaveBeenCalledTimes(1);
  alert.mockRestore();

  // Please fill out this field.: email Please fill out this field.: password
});
test('When submit button is pressed and password fields has a value  and email field does not have proper email format', async () => {
  const alertMock = jest.spyOn(window, "alert").mockImplementation(() => {});

  window.alert = jest.fn();
  
  const loginButton = await screen.findByRole('button', {name: /login/i });
  const userEmail = "devonivory27@gmail.com";
  const userPassword = "dsdfws";
  const password = await screen.findByRole('textbox', {name: /password/i });
  const email = await screen.findByRole('textbox', {name: /email/i });
  await userEvent.type(password, userPassword);
 
   await userEvent.type(email,userEmail);
   await userEvent.click(loginButton);
   const mockData = { data: { message: "Login Successfully" } };
   axios.post.mockResolvedValue(mockData);
  

  expect(window.alert).toHaveBeenCalledTimes(1);
  
  alert.mockRestore();
  await waitFor (( () => {
     expect(alertMock).toHaveBeenCalledWith("Login Successfully");
  }));
 

  // Please fill out this field.: email Please fill out this field.: password
});

}) 


