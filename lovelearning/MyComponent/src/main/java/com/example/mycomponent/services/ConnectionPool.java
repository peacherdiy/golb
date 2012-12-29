package com.example.mycomponent.services;

import java.sql.Connection;

public interface ConnectionPool {
	Connection getConnection();
}
