import { render, screen } from '@testing-library/react';
import App from './App';
import userEvent from '@testing-library/user-event'
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
}) ;


