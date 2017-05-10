/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.task.core;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.pragmatic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.result.PragmaticBookSelfResult;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * Base task for all the task upcoming.
 * 
 * @author amar
 *
 */
public abstract class PragmaticBookselfTask<Result> {
	/**
	 * Initializes all the required data along with the validation of security
	 * session
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	public void init(PragmaticBookselfSession session, StorageContext context) throws PragmaticBookSelfException {
		/*
		 * todo : session check for existance of session
		 */

		Transaction transaction = null;
		try {
			transaction = context.getHibernateSession().beginTransaction();
			context.setTransaction(transaction);
		} catch (HibernateException | PragmaticBookSelfException e) {
			throw new PragmaticBookSelfException(e);
		}
	}

	/**
	 * Closes the connection stablished.
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	private void close(PragmaticBookselfSession session, StorageContext context) throws PragmaticBookSelfException {
		try {
			context.close();
		} catch (Exception e) {
			throw new PragmaticBookSelfException(e);
		}
	}

	/**
	 * Validates the parameter passed based requirement of task.
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	protected abstract void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException;

	/**
	 * Defines the basic step for execution of task.
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	public PragmaticBookSelfResult<Result> executeTask(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		PragmaticBookSelfResult<Result> result = null;
		try {
			init(session, context);
			validateParameter(session, context);
			result = execute(session, context);
			context.commitTransaction();
		} catch (Exception e) {
			context.rollbackTransaction();
			throw new PragmaticBookSelfException(e);
		} finally {
			try {
				close(session, context);
			} catch (Exception e) {
				throw new PragmaticBookSelfException(e);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	protected abstract PragmaticBookSelfResult<Result> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException;
}
