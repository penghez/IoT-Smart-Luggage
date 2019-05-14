from app import app
from flask import Flask, request, abort, url_for, redirect, jsonify
from .models import *
import datetime
from sqlalchemy import text


@app.route('/')
def index():
    return "Hello, IoT!"


@app.route('/journeys')
def journeys():
    cur_date = datetime.date.today()
    journeys = Journeys.query.filter(text("date>'%s'" % cur_date))
    return format_data(msg="200", data=Journeys.serialize_list(journeys))


@app.route('/add/journey', methods=['GET', 'POST'])
def add_journey():
    destination = request.args.get('destination', None)
    date = request.args.get('date', None)
    
    if not date or not destination:
        abort(500)
    
    new_journey = Journeys(date=date, destination=destination)
    db.session.add(new_journey)
    db.session.commit()
    return format_data(msg="200", data=[])


@app.route('/favicon.ico')
def favicon():
    return "no favicon."


def format_data(msg, data):
    return jsonify(
        {
            "msg": msg,
            "data": data
        }
    )