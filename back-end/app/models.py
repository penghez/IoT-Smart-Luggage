from app import db
from sqlalchemy.inspection import inspect


class Serializer(object):
    def serialize(self):
        return {c: getattr(self, c) for c in inspect(self).attrs.keys()}

    @staticmethod
    def serialize_list(l):
        return [m.serialize() for m in l]


class Journeys(db.Model, Serializer):
    __tablename__ = 'journeys'
    jid = db.Column(db.Integer, primary_key=True, autoincrement=True)
    date = db.Column(db.Date, nullable=False)
    destination = db.Column(db.String(200), nullable=False)


class Objects(db.Model):
    __tablename__ = 'objects'
    oid = db.Column(db.Integer, primary_key=True, autoincrement=True)
    oname = db.Column(db.String(200), nullable=False)


class Schedules(db.Model):
    __tablename__ = 'schedules'
    __table_args__ = (
        db.PrimaryKeyConstraint('oid', 'jid'),
    )
    jid = db.Column(db.Integer, db.ForeignKey('journeys.jid'))
    oid = db.Column(db.Integer, db.ForeignKey('objects.oid'))
    amount = db.Column(db.Integer, nullable=False)