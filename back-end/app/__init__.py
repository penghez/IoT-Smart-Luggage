from flask import Flask
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__, static_path='', static_url_path='')
app.config.from_object('config')
app.config['SECRET_KEY'] = '123456'  
db = SQLAlchemy(app)


from app import routes, models