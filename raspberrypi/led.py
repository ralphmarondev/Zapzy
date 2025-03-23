import time
import requests
import RPi.GPIO as GPIO

# Configuration
API_URL = 'http://192.168.1.108:8000/api/led/1/'
LED_PIN = 18

# Set up the GPIO pins
GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)

def get_led_status():
    try:
      response = requests.get(API_URL, timeout=5)
      if response.status_code == 200:
          data = response.json()
          return data['status']
    except requests.RequestException as e:
        print(f'Error fetching LED status: {e}')
    return None

def control_led(status):
    while True:
        status = get_led_status()
        if status is not None:
            GPIO.output(LED_PIN, GPIO.HIGH if status else GPIO.LOW)
            print(f'LED status: {"ON" if status else "OFF"}')
        else:
            print('Failed to fetch LED status')
        time.sleep(2)

if __name__ == '__main__':
    try:
        control_led()
    except KeyboardInterrupt:
        print('Exiting...')
    finally:
        GPIO.cleanup()
